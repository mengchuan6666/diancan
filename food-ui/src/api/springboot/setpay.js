import request from '@/utils/request'

// 查询充值配置列表
export function listSetpay(query) {
  return request({
    url: '/springboot/setpay/list',
    method: 'get',
    params: query
  })
}

// 查询充值配置详细
export function getSetpay(id) {
  return request({
    url: '/springboot/setpay/' + id,
    method: 'get'
  })
}

// 新增充值配置
export function addSetpay(data) {
  return request({
    url: '/springboot/setpay',
    method: 'post',
    data: data
  })
}

// 修改充值配置
export function updateSetpay(data) {
  return request({
    url: '/springboot/setpay',
    method: 'put',
    data: data
  })
}

// 删除充值配置
export function delSetpay(id) {
  return request({
    url: '/springboot/setpay/' + id,
    method: 'delete'
  })
}
