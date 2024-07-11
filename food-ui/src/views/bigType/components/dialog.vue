<template>
    <el-dialog
        model-value="dialogVisible"
        :title="dialogTitle"
        width="30%"
        @close="handleClose"
    >
        <el-form
            ref="formRef"
            :model="form"
            :rules="rules"
            label-width="100px"
        >
            <el-form-item label="大类名称" prop="name">
                <el-input v-model="form.name"/>
            </el-form-item>
            <el-form-item label="大类描述" prop="remark">
                <el-input v-model="form.remark" type="textarea" :rows="4"/>
            </el-form-item>

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
import {defineEmits, defineProps, ref, watch} from "vue";
import axios from 'axios'
import {getServerUrl} from '@/utils/request'
import {ElMessage} from 'element-plus'

const tableData = ref([])

const props = defineProps(
    {
        id: {
            type: Number,
            default: -1,
            required: true
        },
        dialogTitle: {
            type: String,
            default: '',
            required: true
        },
        dialogVisible: {
            type: Boolean,
            default: false,
            required: true
        }
    }
)
const form = ref({
    id: -1,
    name: "",
    remark: ""
})

const rules = ref({
    name: [
        {required: true, message: '请输入食品大类名称'}
    ],
    remark: [
        {required: true, message: '请输入食品大类描述'}
    ]
})

const formRef = ref(null)

const initFormData = async (id) => {
    const res = await axios.get("http://localhost:9091/admin/bigType/" + id);
    form.value = res.data.bigType;
}


watch(
    () => props.dialogVisible,
    () => {
        let id = props.id;
        if (id != -1) {
            initFormData(id)
        } else {

            form.value = {
                id: -1,
                name: "",
                remark: ""
            }
        }

    }
)

const emits = defineEmits(['update:modelValue', 'initBigTypeList'])

const handleClose = () => {
    emits('update:modelValue', false)
}

const handleConfirm = () => {
    formRef.value.validate(async (valid) => {
        if (valid) {
            let result = await axios.post("http://localhost:9091/admin/bigType/save", form.value);
            let data = result.data;
            if (data.code == 0) {
                ElMessage.success("执行成功!")
                formRef.value.resetFields();
                emits("initBigTypeList")
                handleClose();
            } else {
                ElMessage.error(data.msg);
            }
        } else {
            console.log("fail")
        }
    })
}
</script>

<style scoped>

</style>
