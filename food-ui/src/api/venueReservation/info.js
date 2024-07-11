import request from '@/utils/request'

// 查询用户建议列表
export function listInfo(query) {
  return request({
    url: '/suggestInfo/list',
    method: 'get',
    params: query
  })
}

// 查询用户建议详细
export function getInfo(id) {
  return request({
    url: '/suggestInfo/' + id,
    method: 'get'
  })
}

// 新增用户建议
export function addInfo(data) {
  return request({
    url: '/suggestInfo',
    method: 'post',
    data: data
  })
}

// 修改用户建议
export function updateInfo(data) {
  return request({
    url: '/suggestInfo',
    method: 'put',
    data: data
  })
}

// 删除用户建议
export function delInfo(id) {
  return request({
    url: '/suggestInfo/' + id,
    method: 'delete'
  })
}
