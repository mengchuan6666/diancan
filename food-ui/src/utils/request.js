import axios from "axios";
import router from "@/router";
import { Notification, MessageBox, Message, Loading } from "element-ui";


let baseUrl="http://localhost:9091/venueReservation";
const request = axios.create({
  baseURL: baseUrl,
  timeout: 5000,
});

let downloadLoadingInstance;
// 通用下载方法
export function download(url, params, filename) {
  downloadLoadingInstance = Loading.service({
    text: "正在下载数据，请稍候",
    spinner: "el-icon-loading",
    background: "rgba(0, 0, 0, 0.7)",
  });
  return request
    .post(url, params, {
      transformRequest: [
        (params) => {
          return tansParams(params);
        },
      ],
      headers: { "Content-Type": "application/x-www-form-urlencoded" },
      responseType: "blob",
    })
    .then(async (data) => {
      //   const isLogin = await blobValidate(data);
      //   if (isLogin) {
      //     const blob = new Blob([data])
      //     saveAs(blob, filename)
      //   } else {
      const resText = await data.text();
      const rspObj = JSON.parse(resText);
      const errMsg =
        errorCode[rspObj.code] || rspObj.msg || errorCode["default"];
      Message.error(errMsg);
      //   }
      downloadLoadingInstance.close();
    })
    .catch((r) => {
      console.error(r);
      Message.error("下载文件出现错误，请联系管理员！");
      downloadLoadingInstance.close();
    });
}

// request 拦截器
// 可以自请求发送前对请求做一些处理
// 比如统一加token，对请求参数统一加密
request.interceptors.request.use(
  (config) => {
    // var zhuan = localStorage.getItem("zhuanye");
    config.headers["Content-Type"] = "application/json;charset=utf-8";
    let user = localStorage.getItem("user")
      ? JSON.parse(localStorage.getItem("user"))
      : null;
    if (user) {
      config.headers["token"] = user.token; // 设置请求头
      config.data = {
        // zhuanye_id:zhuan,
        ...config.data,
      };
    }

    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

// response 拦截器
// 可以在接口响应后统一处理结果
request.interceptors.response.use(
  (response) => {

    let res = response.data;
    // 如果是返回的文件
    if (response.config.responseType === "blob") {
      return res;
    }
    // 兼容服务端返回的字符串数据
    if (typeof res === "string") {
      res = res ? JSON.parse(res) : res;
    }
    // 当权限验证不通过的时候给出提示
    if (res.code === 401) {
      // ElementUI.Message({
      //     message: res.msg,
      //     type: 'error'
      // });
      router.push("/login");
    }
    if (res.code === 400) {
      ElementUI.Message({
        message: res.msg,
        type: "error",
      });
    }
    return res;
  },
  (error) => {
    console.log("err" + error); // for debug
    return Promise.reject(error);
  }
);

export function getServerUrl(){
    return baseUrl;
}


export function tansParams(params) {
  let result = "";
  for (const propName of Object.keys(params)) {
    const value = params[propName];
    var part = encodeURIComponent(propName) + "=";
    if (value !== null && typeof value !== "undefined") {
      if (typeof value === "object") {
        for (const key of Object.keys(value)) {
          if (value[key] !== null && typeof value[key] !== "undefined") {
            let params = propName + "[" + key + "]";
            var subPart = encodeURIComponent(params) + "=";
            result += subPart + encodeURIComponent(value[key]) + "&";
          }
        }
      } else {
        result += part + encodeURIComponent(value) + "&";
      }
    }
  }
  return result;
}

export default request;
