<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="订单号" prop="orderno">
        <el-input v-model="queryParams.orderno" placeholder="请输入订单号" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>

      <el-form-item label="联系电话" prop="telnumber">
        <el-input v-model="queryParams.telnumber" placeholder="请输入联系电话" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
          v-hasPermi="['venueReservation:order:remove']">删除</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="orderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="订单号" align="center" prop="orderno" />
      <el-table-column label="总价" align="center" prop="totalprice" />
      <el-table-column label="订单创建日期" align="center" prop="createdate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createdate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="就餐人数" align="center" prop="eatNum" />
      <el-table-column label="桌号" align="center" prop="tableNum" />
      <el-table-column label="订单详情" align="center">
        <template slot-scope="scope" >
          <el-button  type="text" @click="getOrderDetails(scope.row)">菜单详情</el-button>
          <el-dialog title="菜单详情" :visible.sync="dialogTableVisible"  width=30%>
            <el-table :data="gridData">
              <el-table-column property="goodsname" label="菜品" align="center" width="200"/>
              <el-table-column property="goodsnumber" label="数量" align="center" >
                <template slot-scope="scope">
                  {{ scope.row.goodsnumber }}<span>份</span>
                </template>
              </el-table-column>
            </el-table>
          </el-dialog>
        </template>


      </el-table-column>
      <el-table-column label="订单状态 " align="center" prop="statusd" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" v-if="scope.row.status == 2"
            @click="handleUpdate(scope.row)" v-hasPermi="['venueReservation:order:edit']">上餐</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
            v-hasPermi="['venueReservation:order:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="订单号" prop="orderno">
          <el-input v-model="form.orderno" placeholder="请输入订单号" />
        </el-form-item>
        <el-form-item label="openId微信用户ID" prop="userid">
          <el-input v-model="form.userid" placeholder="请输入openId微信用户ID" />
        </el-form-item>
        <el-form-item label="总价" prop="totalprice">
          <el-input v-model="form.totalprice" placeholder="请输入总价" />
        </el-form-item>
        <el-form-item label="收货地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入收货地址" />
        </el-form-item>
        <el-form-item label="收货人" prop="consignee">
          <el-input v-model="form.consignee" placeholder="请输入收货人" />
        </el-form-item>
        <el-form-item label="联系电话" prop="telnumber">
          <el-input v-model="form.telnumber" placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item label="订单创建日期" prop="createdate">
          <el-date-picker clearable v-model="form.createdate" type="date" value-format="yyyy-MM-dd"
            placeholder="请选择订单创建日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="订单支付日期" prop="paydate">
          <el-date-picker clearable v-model="form.paydate" type="date" value-format="yyyy-MM-dd" placeholder="请选择订单支付日期">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listOrder, getOrder, delOrder, addOrder, updateOrder } from "@/api/venueReservation/order";
import { listOrdersDetail } from "@/api/springboot/ordersDetial";

export default {
  name: "Order",
  data() {
    return {
      dialogTableVisible: false,
      gridData: [],
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 表格数据
      orderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        orderno: null,
        userid: null,
        totalprice: null,
        address: null,
        consignee: null,
        telnumber: null,
        createdate: null,
        paydate: null,
        status: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询列表 */
    getList() {
      this.loading = true;
      listOrder(this.queryParams).then(response => {
        this.orderList = response.rows;
        this.orderList.map(item => {
          if (item.status == 1) {
            item.statusd = '已取消'
          } else if (item.status == 2) {
            item.statusd = '待上餐'
          } else if (item.status == 3) {
            item.statusd = '待评价'
          } else if (item.status == 4) {
            item.statusd = '已完成'
          } else if (item.status == 4) {
            item.statusd = ''
          }
        })
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        orderno: null,
        userid: null,
        totalprice: null,
        address: null,
        consignee: null,
        telnumber: null,
        createdate: null,
        paydate: null,
        status: 0
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getOrder(id).then(response => {
        this.form = response.data;
        this.form.status = 3;
        updateOrder(this.form).then(response => {
          this.$modal.msgSuccess("修改成功");
          this.getList();
        });
      });


    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateOrder(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOrder(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除编号为"' + ids + '"的数据项？').then(function () {
        return delOrder(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => { });
    },

    getOrderDetails(row) {
      listOrdersDetail({ mid: row.id }).then(response => {
        this.dialogTableVisible = true
        this.gridData = response.rows;
      });;

    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('venueReservation/order/export', {
        ...this.queryParams
      }, `order_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
