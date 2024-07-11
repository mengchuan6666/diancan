import request from '@/utils/request'

// 查询充值记录列表
export function listPayrecord(query) {
  return request({
    url: '/springboot/payrecord/list',
    method: 'get',
    params: query
  })
}

// 查询充值记录详细
export function getPayrecord(id) {
  return request({
    url: '/springboot/payrecord/' + id,
    method: 'get'
  })
}

// 新增充值记录
export function addPayrecord(data) {
  return request({
    url: '/springboot/payrecord',
    method: 'post',
    data: data
  })
}

// 修改充值记录
export function updatePayrecord(data) {
  return request({
    url: '/springboot/payrecord',
    method: 'put',
    data: data
  })
}

// 删除充值记录
export function delPayrecord(id) {
  return request({
    url: '/springboot/payrecord/' + id,
    method: 'delete'
  })
}
