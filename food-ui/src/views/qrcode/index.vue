<template>
    <div class="app-container">
        <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch"
                 label-width="68px">

            <el-form-item label="桌号" prop="tableNum">
                <el-input
                    v-model="queryParams.tableNum"
                    placeholder="请输入桌号"
                    clearable
                    @keyup.enter.native="handleQuery"
                />
            </el-form-item>

            <el-form-item>
                <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
                <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
            </el-form-item>
        </el-form>

        <el-row :gutter="10" class="mb8">
            <el-col :span="1.5">
                <el-button
                    type="primary"
                    plain
                    icon="el-icon-plus"
                    size="mini"
                    @click="handleAdd"
                    v-hasPermi="['venueReservation:code:add']"
                >新增
                </el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button
                    type="success"
                    plain
                    icon="el-icon-edit"
                    size="mini"
                    :disabled="single"
                    @click="handleUpdate"
                    v-hasPermi="['venueReservation:code:edit']"
                >修改
                </el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button
                    type="danger"
                    plain
                    icon="el-icon-delete"
                    size="mini"
                    :disabled="multiple"
                    @click="handleDelete"
                    v-hasPermi="['venueReservation:code:remove']"
                >删除
                </el-button>
            </el-col>

            <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>

        <el-table v-loading="loading" :data="codeList" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55" align="center"/>
            <el-table-column label="主键" align="center" prop="id"/>
            <el-table-column label="餐厅 id" align="center" prop="canteenId"/>
            <el-table-column label="桌号" align="center" prop="tableNum"/>
            <el-table-column label="二维码图片">
                <template slot-scope="scope">
                    <el-image style="width: 100px; height: 100px" :src="scope.row.codeUrl"
                              :preview-src-list="[scope.row.value]"></el-image>
                </template>
            </el-table-column>
            <el-table-column label="创建人" align="center" prop="createdBy"/>
            <el-table-column label="创建时间" align="center" prop="createdTime" width="180">
                <template slot-scope="scope">
                    <span>{{ parseTime(scope.row.createdTime, '{y}-{m}-{d}') }}</span>
                </template>
            </el-table-column>
            <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
                <template slot-scope="scope">
                    <el-button
                        size="mini"
                        type="text"
                        icon="el-icon-edit"
                        @click="handleUpdate(scope.row)"
                        v-hasPermi="['venueReservation:code:edit']"
                    >修改
                    </el-button>
                    <el-button
                        size="mini"
                        type="text"
                        icon="el-icon-delete"
                        @click="handleDelete(scope.row)"
                        v-hasPermi="['venueReservation:code:remove']"
                    >删除
                    </el-button>
                </template>
            </el-table-column>
        </el-table>

        <pagination
            v-show="total>0"
            :total="total"
            :page.sync="queryParams.pageNum"
            :limit.sync="queryParams.pageSize"
            @pagination="getList"
        />

        <!-- 添加或修改二维码管理对话框 -->
        <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
            <el-form ref="form" :model="form" :rules="rules" label-width="80px">
                <el-form-item label="餐厅 id" prop="canteenId">
                    <el-input v-model="form.canteenId" placeholder="请输入餐厅 id"/>
                </el-form-item>
                <el-form-item label="桌号" prop="tableNum">
                    <el-input v-model="form.tableNum" placeholder="请输入桌号"/>
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
import {listCode, getCode, delCode, addCode, updateCode} from "@/api/venueReservation/code";

export default {
    name: "Code",
    data() {
        return {
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
            // 二维码管理表格数据
            codeList: [],
            // 弹出层标题
            title: "",
            // 是否显示弹出层
            open: false,
            // 查询参数
            queryParams: {
                pageNum: 1,
                pageSize: 10,
                canteenId: null,
                tableNum: null,
                codeUrl: null,
                createdBy: null,
                createdTime: null,
                updatedBy: null,
                updatedTime: null
            },
            // 表单参数
            form: {},
            // 表单校验
            rules: {
                canteenId: [
                    {required: true, message: "餐厅 id不能为空", trigger: "blur"}
                ],
                tableNum: [
                    {required: true, message: "桌号不能为空", trigger: "blur"}
                ],
                codeUrl: [
                    {required: true, message: "二维码图片不能为空", trigger: "blur"}
                ],
            }
        };
    },
    created() {
        this.getList();
    },
    methods: {
        /** 查询二维码管理列表 */
        getList() {
            this.loading = true;
            listCode(this.queryParams).then(response => {
                this.codeList = response.rows;
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
                canteenId: null,
                tableNum: null,
                codeUrl: null,
                createdBy: null,
                createdTime: null,
                updatedBy: null,
                updatedTime: null
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
            this.title = "添加二维码管理";
        },
        /** 修改按钮操作 */
        handleUpdate(row) {
            this.reset();
            const id = row.id || this.ids
            getCode(id).then(response => {
                this.form = response.data;
                this.open = true;
                this.title = "修改二维码管理";
            });
        },
        /** 提交按钮 */
        submitForm() {
            this.$refs["form"].validate(valid => {
                if (valid) {
                    if (this.form.id != null) {
                        updateCode(this.form).then(response => {
                            this.$modal.msgSuccess("修改成功");
                            this.open = false;
                            this.getList();
                        });
                    } else {
                        addCode(this.form).then(response => {
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
            this.$modal.confirm('是否确认删除二维码管理编号为"' + ids + '"的数据项？').then(function () {
                return delCode(ids);
            }).then(() => {
                this.getList();
                this.$modal.msgSuccess("删除成功");
            }).catch(() => {
            });
        },
        /** 导出按钮操作 */
        handleExport() {
            this.download('venueReservation/code/export', {
                ...this.queryParams
            }, `code_${new Date().getTime()}.xlsx`)
        },
        handleImgUploadSuccess(res) {
            console.log(res)
            this.form.value = res.data
        },
    }
};
</script>
