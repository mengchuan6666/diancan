<template>
  <div style="color: #666;font-size: 14px;">
<!--    <div style="padding-bottom: 20px">-->
      <b>您好！{{ user.nickname }}</b>
<!--    </div>-->
<!--    <el-card>-->
      <News></News>
<!--    </el-card>-->
  </div>
</template>

<script>
import News from './News'
export default {
  components: { News },
  name: "Home",
  data() {
    return {
      dialogFormVisible: false,
      tableData: [],
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
    }
  },
  created() {
    this.load()
    this.dialogFormVisible = true
  },
  methods: {
    load() {
      // this.request.get("/notice/page", {
      //   params: {
      //     pageNum: 1,
      //     pageSize: 20,
      //   }
      // }).then(res => {
      //   this.tableData = res.data.records
      //   this.total = res.data.total
      // })
    },
  }
}
</script>
