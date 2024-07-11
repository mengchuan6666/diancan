<template>
  <el-dialog
      model-value="dialogVisible"
      :title="dialogTitle"
      width="50%"
      @close="handleClose"
  >
    <el-form
        ref="formRef"
        :model="form"
        :rules="rules"
        label-width="100px"
    >
      <el-form-item label="食品名称" prop="name">
        <el-input v-model="form.name" style="width: 400px"/>
      </el-form-item>

      <el-form-item label="食品价格" prop="price">
        <el-input v-model="form.price" style="width: 100px"/>
      </el-form-item>

      <el-form-item label="食品库存" prop="stock">
        <el-input v-model="form.stock" style="width: 100px"/>
      </el-form-item>

      <el-form-item label="食品类别">
        <el-select v-model="bigTypeId" class="m-2" placeholder="请选择食品大类..." @change="handleBigTypeChange">
          <el-option
              v-for="item in bigTypeSelectOptions"
              :key="item.id"
              :label="item.name"
              :value="item.id"></el-option>
        </el-select>
        &nbsp;&nbsp;
        <el-select v-model="form.type.id" class="m-2" placeholder="请选择食品小类...">
          <el-option
              v-for="item in smallTypeSelectOptions"
              :key="item.id"
              :label="item.name"
              :value="item.id"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="食品描述" prop="description">
        <el-input v-model="form.description" type="textarea" :rows="4"/>
      </el-form-item>

      <el-form-item label="食品介绍" style="position: relative;"></el-form-item>
      <el-upload
        class="universityDepartments"
        :action="getServerUrl()+'/admin/product/uploadImage'"
      name="file"
      :headers="headers"
      :show-file-list="false"
      :on-success="uploadSuccess"
    >
    <img class="up-img" src="../../../assets//qq.jpg" alt="">
   </el-upload>
      <QuillEditor
        v-model:content="form.productIntroImgs"
        contentType="html"
        ref="quillEditor"
        :options="departmentsOption"
        toolbar="full"
        theme="snow"
        style="height: 200px"
      >
      </QuillEditor>

      <el-form-item label="食品参数"></el-form-item>
      <el-upload
        class="universityDepartments"
        :action="getServerUrl()+'/admin/product/uploadImage'"
      name="file"
      :headers="headers"
      :show-file-list="false"
      :on-success="uploadSuccesss"
    >
    <img class="up-img1" src="../../../assets//qq.jpg" alt="">
   </el-upload>
      <QuillEditor
          v-model:content="form.productParaImgs"
          contentType="html"
          toolbar="full"
          theme="snow"
          ref="quillEditors"
          style="height: 200px"
      >
      </QuillEditor>

    </el-form>
    <template #footer>
      <span class="dialog-footer">
          <el-button @click="handleClose">取消</el-button>
          <el-button type="primary" @click="handleConfirm">确认</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup>
import {defineEmits, defineProps,ref, watch} from "vue";
import { ElMessage } from 'element-plus'
import axios from 'axios'
import { getServerUrl } from '@/utils/request'

const props=defineProps(
    {
      id:{
        type:Number,
        default:-1,
        required:true
      },
      dialogTitle:{
        type:String,
        default:'',
        required:true
      },
      dialogVisible:{
        type:Boolean,
        default:false,
        required:true
      }
    }
)
const form = ref({
  id:-1,
  name:"",
  price:null,
  stock:null,
  type:{
    id:''
  },
  description:"",
  productIntroImgs:"",
  productParaImgs:""
})

const bigTypeId=ref("")

const smallTypeSelectOptions=ref([]);

const bigTypeSelectOptions=ref([]);



const initBigTypeSelectList=async()=>{
  const res=await axios.get("/bigType/listAll");
  bigTypeSelectOptions.value=res.data.bigTypeList;
}

const initSmallTypeSelectList=async(bigTypeId)=>{
  form.value.type.id=""
  const res=await axios.get("/smallType/listAll/"+bigTypeId);
  smallTypeSelectOptions.value=res.data.smallTypeList;
}

initBigTypeSelectList();

const rules=ref({
  name: [
    { required: true,
      message: '请输入食品小类名称'
    }
  ],
  price:[
    {required:true,message:'请输入食品价格！'},
    {type:'number',message: '食品价格是数值类型！',transform:(value)=>Number(value)},
  ],
  stock:[
    {required:true,message:'请输入食品库存！'},
    {type:'number',message: '食品库存是数值类型！',transform:(value)=>Number(value)},
  ],
  description: [
    { required: true,
      message: '请输入食品描述',
    },
  ],
})

const formRef=ref(null)

const initFormData=async(id)=>{
  const res = await axios.get("/product/"+id);
  bigTypeId.value=res.data.product.type.bigType.id;
  initSmallTypeSelectList(bigTypeId.value);
  form.value=res.data.product;
}

const handleBigTypeChange=(bigTypeId)=>{
  console.log("bigTypeId="+bigTypeId);
  initSmallTypeSelectList(bigTypeId)
}



watch(
    ()=>props.dialogVisible,
    ()=>{
      let id=props.id;
      if(id!=-1){
        initFormData(id)
      }else{
        form.value={
          id:-1,
          name:"",
          price:null,
          stock:null,
          type:{
            id:""
          },
          description:""
        }
      }

    }
)

const headers=ref({
  token:window.sessionStorage.getItem("token")
})
const emits=defineEmits(['update:modelValue','initProductList'])

const handleClose=()=>{
  emits('update:modelValue',false)
}

const handleConfirm=()=>{
  formRef.value.validate(async(valid)=>{
    if(valid){
      if(form.value.type.id==""){
        ElMessage.error("请选择食品类别");
        return;
      }
      let result=await axios.post("/product/save",form.value);
      let data=result.data;
      if(data.code==0){
        ElMessage.success("执行成功!")
        formRef.value.resetFields();
        emits("initProductList")
        handleClose();
      }else{
        ElMessage.error(data.msg);
      }
    }else{
      console.log("fail")
    }
  })
}
</script>
<script>
 export default {
  data(){
    return{
      departmentsOption: {
                placeholder: '请输入...',
                theme: "snow", // 编辑器主题，可选 "snow" 或 "bubble"
                modules: {
                  toolbar: [
            ["bold", "italic", "underline", "strike"], // 格式化文本的工具栏按钮
            ["blockquote", "code-block"],
            [{ header: 1 }, { header: 2 }], // 标题样式
            [{ list: "ordered" }, { list: "bullet" }], // 列表样式
            [{ script: "sub" }, { script: "super" }], // 上标和下标
            [{ indent: "-1" }, { indent: "+1" }], // 缩进
            [{ direction: "rtl" }], // 文本方向
            [{ size: ["small", false, "large", "huge"] }], // 字体大小
            [{ header: [1, 2, 3, 4, 5, 6, false] }], // 自定义标题级别
            [{ color: [] }, { background: [] }], // 文本颜色和背景色
            [{ font: [] }], // 字体
            [{ align: [] }], // 文本对齐
            ["link",  "video"], // 插入链接、图片和视频
            ["clean"], // 清除格式按钮
          ],
                },
                // 禁用默认的图片上传
                clipboard: {
                  matchVisual: false,
                },
            },  // 富文本框的option
    }
  },
  created(){
    console.log(this.quill)
  },
  mounted() {
    // 在 mounted 钩子中访问 quill
    this.$nextTick(()=>{
      const quill = this.$refs.quillEditor;
      console.log(quill,'snn');
    })

  },
  computed: {
        editor() {
            return this.$refs.quillEditor.quill;
        },
    },

  methods:{
    uploadSuccess(res) {
      this.$nextTick(()=>{
        let dequill = this.$refs.quillEditor.getQuill()
        // 如果上传成功
        console.log(this.$refs.quillEditor.getQuill(),'dd')
        if (res) {
            // 获取光标所在位置
            console.log(dequill.selection.savedRange,'dndndnndnd')
            let delength = dequill.selection.savedRange.index;

            // 插入图片，res为服务器返回的图片链接地址
            dequill.insertEmbed(delength, 'image', getServerUrl()+res.data.src)
            // 调整光标到最后
            dequill.setSelection(delength + 1)
        } else {
            // 提示信息，需引入Message
            Message.error('图片插入失败')
        }
      })
    },
    uploadSuccesss(res){
      this.$nextTick(()=>{
        let dequill = this.$refs.quillEditors.getQuill()
        // 如果上传成功
        console.log(this.$refs.quillEditors.getQuill(),'dd')
        if (res) {
            // 获取光标所在位置
            console.log(dequill.selection.savedRange,'dndndnndnd')
            let delength = dequill.selection.savedRange.index;

            // 插入图片，res为服务器返回的图片链接地址
            dequill.insertEmbed(delength, 'image', getServerUrl()+res.data.src)
            // 调整光标到最后
            dequill.setSelection(delength + 1)
        } else {
            // 提示信息，需引入Message
            Message.error('图片插入失败')
        }
      })
    },
  }
 }
</script>

<style scoped>
/deep/.universityDepartments {
  width: 20px;
  height: 20px;
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
</style>
