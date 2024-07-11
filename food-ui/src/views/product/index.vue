<template>
    <div class="app-container">
        <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
            <el-form-item label="商品名称" prop="name">
                <el-input v-model="queryParams.name" placeholder="请输入商品名称" clearable @keyup.enter.native="handleQuery" />
            </el-form-item>

            <el-form-item label="库存" prop="stock">
                <el-input v-model="queryParams.stock" placeholder="请输入库存" clearable @keyup.enter.native="handleQuery" />
            </el-form-item>


            <el-form-item>
                <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
                <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
            </el-form-item>
        </el-form>

        <el-row :gutter="10" class="mb8">
            <el-col :span="1.5">
                <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
                    v-hasPermi="['venueReservation:product:add']">新增
                </el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate"
                    v-hasPermi="['venueReservation:product:edit']">修改
                </el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
                    v-hasPermi="['venueReservation:product:remove']">删除
                </el-button>
            </el-col>

            <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>

        <el-table v-loading="loading" :data="productList" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55" align="center" />
            <el-table-column label="编号" align="center" prop="id" width="35" />
            <el-table-column label="商品名称" align="center" prop="name" />
            <el-table-column label="商品价格" align="center" prop="price" />
            <el-table-column label="库存" align="center" prop="stock" />
            <el-table-column label="状态" align="center" prop="proStatus">
                <template v-slot="scope">
            <span>{{ optionsupDown.find(v => v.value === scope.row.proStatus) ? optionsupDown.find(v => v.value === scope.row.proStatus).name : ''  }}</span>
          </template>
            </el-table-column>
            <el-table-column label="商品图片">
                <template slot-scope="scope">
                    <el-image style="width: 100px; height: 100px" :src="scope.row.propic"
                        :preview-src-list="[scope.row.propic]"></el-image>
                </template>
            </el-table-column>
            <el-table-column label="商品轮播图片" align="center" prop="productSwiperImageList">
                <template slot-scope="scope">

                    <el-image style="width: 100px; height: 100px"
                        v-if="scope.row.productSwiperImageList && scope.row.productSwiperImageList[0]"
                        :src="scope.row.productSwiperImageList[0].image"
                        :preview-src-list="[scope.row.productSwiperImageList[0].image]"></el-image>
                    <el-image style="width: 100px; height: 100px"
                        v-if="scope.row.productSwiperImageList && scope.row.productSwiperImageList[1]"
                        :src="scope.row.productSwiperImageList[1].image"
                        :preview-src-list="[scope.row.productSwiperImageList[1].image]"></el-image>
                    <el-image style="width: 100px; height: 100px"
                        v-if="scope.row.productSwiperImageList && scope.row.productSwiperImageList[2]"
                        :src="scope.row.productSwiperImageList[2].image"
                        :preview-src-list="[scope.row.productSwiperImageList[2].image]"></el-image>
                </template>
            </el-table-column>
            <el-table-column label="设置热卖日期" align="center" prop="hotdatetime" width="180">
                <template slot-scope="scope">
                    <span>{{ parseTime(scope.row.hotdatetime, '{y}-{m}-{d}') }}</span>
                </template>
            </el-table-column>
            <el-table-column label="商品介绍图片">
                <template slot-scope="scope">
                    <el-image style="width: 100px; height: 100px" :src="scope.row.productintroimgs"
                        :preview-src-list="[scope.row.productintroimgs]"></el-image>
                </template>
            </el-table-column>
            <el-table-column label="商品描述" align="center" prop="description" />
            <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
                <template slot-scope="scope">
                    <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdateDown(scope.row)"
                        v-hasPermi="['venueReservation:product:edit']">下架
                    </el-button>
                    <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                        v-hasPermi="['venueReservation:product:edit']">修改
                    </el-button>
                    <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                        v-hasPermi="['venueReservation:product:remove']">删除
                    </el-button>
                </template>
            </el-table-column>
        </el-table>

        <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
            @pagination="getList" />

        <!-- 添加或修改商品对话框 -->
        <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
            <el-form ref="form" :model="form" :rules="rules" label-width="80px">
                <el-form-item label="商品名称" prop="name">
                    <el-input v-model="form.name" placeholder="请输入商品名称" />
                </el-form-item>
                <el-form-item label="商品价格" prop="price">
                    <el-input v-model="form.price" placeholder="请输入商品价格" />
                </el-form-item>
                <el-form-item label="库存" prop="stock">
                    <el-input v-model="form.stock" placeholder="请输入库存" />
                </el-form-item>
                <el-form-item label="商品图片" prop="propic">
                    <el-upload class="avatar-uploader" action="http://localhost:9091/file/upload" :show-file-list="false"
                        ref="img" accept=".png,.jpeg,.jpg" :on-success="handleImgUploadSuccess">
                        <img v-if="form.propic" :src="form.propic" class="avatar" />
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
                </el-form-item>
                <el-form-item label="是否热门推荐商品" prop="ishot">
                    <el-select clearable v-model="ishot" placeholder="请选择" style="width: 100%">
                        <el-option v-for="item in options" :key="item.name" :label="item.name" :value="item.name">
                            <i :class="item.name" /> {{ item.name }}
                        </el-option>
                    </el-select>
                </el-form-item>

                <el-form-item label="商品轮播图片" prop="productSwiperImageList">
                    <el-upload class="avatar-uploader" action="http://localhost:9091/file/upload" ref="img"
                        accept=".png,.jpeg,.jpg" :on-success="handleImgUploadSucce">
                        <img v-if="form.productSwiperImageList && form.productSwiperImageList[0]"
                            :src="form.productSwiperImageList[0].image" class="avatar" />
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
                    <el-upload class="avatar-uploader" action="http://localhost:9091/file/upload" ref="img"
                        accept=".png,.jpeg,.jpg" :on-success="handleImgUploadSucc">
                        <img v-if="form.productSwiperImageList && form.productSwiperImageList[1]"
                            :src="form.productSwiperImageList[1].image" class="avatar" />
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
                    <el-upload class="avatar-uploader" action="http://localhost:9091/file/upload" ref="img"
                        accept=".png,.jpeg,.jpg" :on-success="handleImgUploadSuc">
                        <img v-if="form.productSwiperImageList && form.productSwiperImageList[2]"
                            :src="form.productSwiperImageList[2].image" class="avatar" />
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
                </el-form-item>

                <el-form-item label="商品类别编号" prop="typeid">
                    <el-input v-model="form.typeid" placeholder="请输入商品类别编号" />
                </el-form-item>
                <el-form-item label="设置热卖日期" prop="hotdatetime">
                    <el-date-picker clearable v-model="form.hotdatetime" type="date" value-format="yyyy-MM-dd"
                        placeholder="请选择设置热卖日期">
                    </el-date-picker>
                </el-form-item>
                <el-form-item label="商品介绍图片" prop="productintroimgs">
                    <el-upload class="avatar-uploader" action="http://localhost:9091/file/upload" :show-file-list="false"
                        ref="img" accept=".png,.jpeg,.jpg" :on-success="handleImgUploadSuccessa">
                        <img v-if="form.productintroimgs" :src="form.productintroimgs" class="avatar" />
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
                </el-form-item>
                <el-form-item label="商品规格参数图片" prop="productparaimgs">
                    <el-upload class="avatar-uploader" action="http://localhost:9091/file/upload" :show-file-list="false"
                        ref="img" accept=".png,.jpeg,.jpg" :on-success="handleImgUploadSucces">
                        <img v-if="form.productparaimgs" :src="form.productparaimgs" class="avatar" />
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
                </el-form-item>
                <el-form-item label="商品描述" prop="description">
                    <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
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
import { listProduct, getProduct, delProduct, addProduct, updateProduct } from "@/api/venueReservation/product";

export default {
    name: "Product",
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
            ishot: '是',
            isswiper: '是',
            // 商品表格数据
            productList: [],
            // 弹出层标题
            title: "",
            // 是否显示弹出层
            open: false,
            ida: null,
            options: [
                {
                    name: '是',
                    value: '1'
                },
                {
                    name: '否',
                    value: '0'
                },
            ],

            optionsupDown: [
                {
                    name: '上架',
                    value: '1'
                },
                {
                    name: '下架',
                    value: '2'
                },
            ],

            // 查询参数
            queryParams: {
                pageNum: 1,
                pageSize: 10,
                name: null,
                price: null,
                stock: null,
                propic: null,
                ishot: null,
                isswiper: null,
                productSwiperImageList: [],
                swipersort: null,
                typeid: null,
                hotdatetime: null,
                productintroimgs: null,
                productparaimgs: null,
                description: null,
                sizes: null
            },
            // 表单参数
            form: {},
            // 表单校验
            rules: {}
        };
    },
    created() {
        this.getList();
    },
    methods: {
        /** 查询商品列表 */
        getList() {
            this.loading = true;
            listProduct(this.queryParams).then(response => {
                this.productList = response.rows;
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
                name: null,
                price: null,
                stock: null,
                propic: null,
                ishot: null,
                isswiper: null,
                productSwiperImageList: [],
                swipersort: null,
                typeid: null,
                hotdatetime: null,
                productintroimgs: null,
                productparaimgs: null,
                description: null,
                sizes: null
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
            this.title = "添加商品";
        },
        handleImgUploadSuccessa(res) {
            console.log(res, 'dbdbdbd')
            this.form.productintroimgs = res.data;
        },
        handleImgUploadSuccess(res) {
            this.form.propic = res.data;
        },
        handleImgUploadSucces(res) {
            this.form.productparaimgs = res.data;
        },
        handleImgUploadSucce(res) {
            var obj = {
                image: res.data,
                productid: this.ida
            }
            this.form.productSwiperImageList[0] = obj
            this.$forceUpdate()
            console.log(this.form.swiperpic, 'this.form.swiperpic')
        },
        handleImgUploadSucc(res) {
            var obj = {
                image: res.data,
                productid: this.ida
            }
            this.form.productSwiperImageList[1] = obj
            this.$forceUpdate()
            console.log(this.form.swiperpic, 'this.form.swiperpic')
        },
        handleImgUploadSuc(res) {
            var obj = {
                image: res.data,
                productid: this.ida
            }
            this.form.productSwiperImageList[2] = obj
            this.$forceUpdate()
            console.log(this.form.swiperpic, 'this.form.swiperpic')
        },
        /** 修改按钮操作 */
        handleUpdate(row) {
            this.reset();
            const id = row.id || this.ids
            this.ida = row.id
            getProduct(id).then(response => {
                this.form = response.data;
                if (this.form.productSwiperImageList == null) {
                    this.form.productSwiperImageList = []
                }
                if (this.form.ishot == 1) {
                    this.ishot = '是'
                } else {
                    this.ishot = '否'
                }
                if (this.form.isswiper == 1) {
                    this.isswiper = '是'
                } else {
                    this.isswiper = '否'
                }
                this.open = true;
                this.title = "修改商品";
            });
        },
        handleUpdateDown(row) {
            this.reset();
            const id = row.id || this.ids
            this.ida = row.id
            updateProduct({ id: row.id, proStatus: 2 }).then(response => {
                this.form = response.data;
                this.$modal.msgSuccess("下架成功");
                this.getList();
            });
        },

        /** 提交按钮 */
        submitForm() {
            if (this.ishot == '是') {
                this.form.ishot = 1
            } else {
                this.form.ishot = 0
            }
            if (this.isswiper == '是') {
                this.form.isswiper = 1
            } else {
                this.form.isswiper = 0
            }
            this.$refs["form"].validate(valid => {
                if (valid) {
                    if (this.form.id != null) {
                        updateProduct(this.form).then(response => {
                            this.$modal.msgSuccess("修改成功");
                            this.open = false;
                            this.getList();
                        });
                    } else {
                        addProduct(this.form).then(response => {
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
            this.$modal.confirm('是否确认删除商品编号为"' + ids + '"的数据项？').then(function () {
                return delProduct(ids);
            }).then(() => {
                this.getList();
                this.$modal.msgSuccess("删除成功");
            }).catch(() => {
            });
        },
        /** 导出按钮操作 */
        handleExport() {
            this.download('venueReservation/product/export', {
                ...this.queryParams
            }, `product_${new Date().getTime()}.xlsx`)
        }
    }
};
</script>

<style scoped>
/deep/.universityDepartments {
    width: 100px;
    height: 100px;
    display: flex;
    align-items: center;
    justify-content: center;
    border: 1px solid;
}

/deep/.el-icon-picture {
    width: 20px;
    height: 20px;
}

/deep/.ql-image {
    display: none !important;
}

.up-img {
    position: absolute;
    top: 495px;
    left: 500px;
    width: 30px;
    height: 30px;
}

.up-img1 {
    position: absolute;
    top: 830px;
    left: 500px;
    width: 30px;
    height: 30px;
}

.avatar-uploader {
    width: 152px;
    height: 152px;
    display: flex;
    align-items: center;
    justify-content: center;
    border: 1px solid #DCDFE6;
}

.el-upload {
    width: 150px !important;
    height: 150px !important;
    border: none;
}

.avatar {
    width: 148px;
    height: 148px;
    margin-top: 10px;
}

.avatar-uploader-icon {
    width: 150px !important;
    height: 150px !important;
    line-height: 150px;
}

.avatar-uploader-icon {
    border: none;
}

/deep/.el-upload-list__item-name,
/deep/.el-upload-list__item-name,
/deep/.el-icon-circle-check:before {
    display: none;
}</style>