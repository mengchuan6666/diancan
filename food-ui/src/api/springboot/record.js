import request from '@/utils/request'

// 查询用户积分记录列表
export function listRecord(query) {
  return request({
    url: '/integralRecord/list',
    method: 'get',
    params: query
  })
}

// 查询用户积分记录详细
export function getRecord(id) {
  return request({
    url: '/integralRecord/' + id,
    method: 'get'
  })
}

// 新增用户积分记录
export function addRecord(data) {
  return request({
    url: '/integralRecord',
    method: 'post',
    data: data
  })
}

// 修改用户积分记录
export function updateRecord(data) {
  return request({
    url: '/integralRecord',
    method: 'put',
    data: data
  })
}

// 删除用户积分记录
export function delRecord(id) {
  return request({
    url: '/integralRecord/' + id,
    method: 'delete'
  })
}
