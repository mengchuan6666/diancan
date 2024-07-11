<template>
    <div class="app-container">
        <div class="overview-layout">
            <el-row :gutter="20">
                <el-col :span="12">
                    <div class="out-border">
                        <div class="layout-title">商品总览</div>
                        <div style="padding: 40px; margin-left: 32px; margin-right: -50px;">
                            <el-row :data="productCountDatas">
                                <el-col :span="6" class="color-danger overview-item-value">{{ productCountDatas.downCount
                                }}</el-col>
                                <el-col :span="6" class="color-danger overview-item-value">{{ productCountDatas.upCount
                                }}</el-col>
                                <el-col :span="6" class="color-danger overview-item-value">{{ productCountDatas.total
                                }}</el-col>
                            </el-row>
                            <el-row class="font-medium">
                                <el-col :span="6" class="overview-item-title">已下架</el-col>
                                <el-col :span="6" class="overview-item-title">已上架</el-col>
                                <el-col :span="6" class="overview-item-title">全部商品</el-col>
                            </el-row>
                        </div>
                    </div>
                </el-col>
                <el-col :span="12">
                    <div class="out-border">
                        <div class="layout-title">用户总览</div>
                        <div style="padding: 40px ;margin-left: 32px;  margin-right: -50px;">
                            <el-row :data="userCountDatas">
                                <el-col :span="6" class="color-danger overview-item-value">{{ userCountDatas.listCoun2
                                }}</el-col>
                                <el-col :span="6" class="color-danger overview-item-value">{{ userCountDatas.listCount
                                }}</el-col>
                                <el-col :span="6" class="color-danger overview-item-value">{{ userCountDatas.count3
                                }}</el-col>
                            </el-row>
                            <el-row class="font-medium">
                                <el-col :span="6" class="overview-item-title">今日新增</el-col>
                                <el-col :span="6" class="overview-item-title">昨日新增</el-col>
                                <el-col :span="6" class="overview-item-title">本月新增</el-col>

                            </el-row>
                        </div>
                    </div>
                </el-col>
            </el-row>
        </div>
        <div class="statistics-layout">
            <div class="layout-title">订单统计</div>
            <el-row>
                <el-col :span="20">
                    <div style="padding: 10px;border-left:1px solid #DCDFE6">
                        <el-date-picker style="float: right;z-index: 1" size="small" v-model="orderCountDate"
                            type="daterange" align="right" unlink-panels range-separator="至" start-placeholder="开始日期"
                            end-placeholder="结束日期" @change="handleDateChange" :picker-options="pickerOptions">
                        </el-date-picker>
                        <div>
                            <ve-line style="width: 990px;" :data="chartData" :legend-visible="false" :loading="loading"
                                :data-empty="dataEmpty" :settings="chartSettings"></ve-line>

                        </div>
                    </div>
                </el-col>
            </el-row>
        </div>
    </div>
</template>

<script>
import { str2Date } from '@/utils/date';
import { getCount, getProductCount, getuserCount } from '@/api/springboot/getCount';
import img_home_order from '@/assets/home_order.png';
import img_home_today_amount from '@/assets/home_today_amount.png';
import img_home_yesterday_amount from '@/assets/home_yesterday_amount.png';
const DATA_FROM_BACKEND = {
    columns: ['date', 'orderCount', 'orderAmount'],
    rows: [
    ]
};
export default {
    name: 'news',
    data() {
        return {
            pickerOptions: {
                shortcuts: [{
                    text: '最近一周',
                    onClick(picker) {
                        const end = new Date();
                        let start = new Date();
                        end.setTime(start.getTime() + 3600 * 1000 * 24 * 7);
                        picker.$emit('pick', [start, end]);
                    }
                }, {
                    text: '最近一月',
                    onClick(picker) {
                        const end = new Date();
                        let start = new Date();
                        start.setDate(1)
                        end.setTime(start.getTime() + 3600 * 1000 * 24 * 30);
                        picker.$emit('pick', [start, end]);
                    }
                }]
            },
            orderCountDate: '',
            chartSettings: {
                // xAxisType: 'time',
                area: true,
                axisSite: { right: ['orderAmount'] },
                labelMap: { 'orderCount': '订单数量', 'orderAmount': '订单金额' }
            },
            chartData: {
                columns: [],
                rows: []
            },
            loading: false,
            dataEmpty: true,
            img_home_order,
            img_home_today_amount,
            img_home_yesterday_amount,
            rowsData: [],
            productCountDatas: '',
            userCountDatas: '',
        }
    },
    created() {
        this.initOrderCountDate();
        this.getCount();
        this.getData();
        this.getProductCountData();
        this.getUserCountData();

    },
    methods: {

        getUserCountData() {
            getuserCount().then(response => {
                this.userCountDatas = response.data;
            });
        },

        getProductCountData() {
            getProductCount().then(response => {
                this.productCountDatas = response.data;
            });
        },

        handleDateChange() {
            this.getData();
        },
        initOrderCountDate() {
            let start = new Date();
            start.setDate(1);
            const end = new Date();
            this.orderCountDate = [start, end];
        },
        getData() {
            setTimeout(() => {
                this.chartData = {
                    columns: ['date', 'orderCount', 'orderAmount'],
                    rows: []
                };
                for (let i = 0; i < this.rowsData.length; i++) {
                    let item = this.rowsData[i];
                    let currDate = str2Date(item.date, '-');
                    let start = this.orderCountDate[0];
                    let end = this.orderCountDate[1];

                    if (currDate.getTime() >= start.getTime() && currDate.getTime() < end.getTime()) {
                        this.chartData.rows.push(item);
                    }
                }

                this.dataEmpty = true;
                this.loading = false
            }, 200)
        },
        getCount() {
            getCount().then(response => {
                this.rowsData = response.data;
            });
        }

    }
}
</script>

<style scoped>
.app-container {
    margin-top: 40px;
    margin-left: 120px;
    margin-right: 120px;
}

.address-layout {}

.total-layout {
    margin-top: 20px;
}

.total-frame {
    border: 1px solid #DCDFE6;
    padding: 20px;
    height: 100px;
}

.total-icon {
    color: #409EFF;
    width: 60px;
    height: 60px;
}

.total-title {
    position: relative;
    font-size: 16px;
    color: #909399;
    left: 70px;
    top: -50px;
}

.total-value {
    position: relative;
    font-size: 18px;
    color: #606266;
    left: 70px;
    top: -40px;
}

.un-handle-layout {
    margin-top: 20px;
    border: 1px solid #DCDFE6;
}

.layout-title {
    color: #606266;
    padding: 15px 20px;
    background: #F2F6FC;
    font-weight: bold;
}

.un-handle-content {
    padding: 20px 40px;
}

.un-handle-item {
    border-bottom: 1px solid #EBEEF5;
    padding: 10px;
}

.overview-layout {
    margin-top: 20px;
}

.overview-item-value {
    font-size: 24px;
    text-align: center;
}

.overview-item-title {
    margin-top: 10px;
    text-align: center;
}

.out-border {
    border: 1px solid #DCDFE6;
}

.statistics-layout {
    margin-top: 20px;
    border: 1px solid #DCDFE6;
}

.mine-layout {
    position: absolute;
    right: 140px;
    top: 107px;
    width: 250px;
    height: 235px;
}

.address-content {
    padding: 20px;
    font-size: 18px
}
/deep/.v-charts-data-empty {
    display: none;
}
</style>
