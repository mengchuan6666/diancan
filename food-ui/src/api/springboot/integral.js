import request from '@/utils/request'

// 查询用户积分列表
export function listIntegral(query) {
  return request({
    url: '/integral/list',
    method: 'get',
    params: query
  })
}

// 查询用户积分详细
export function getIntegral(id) {
  return request({
    url: '/integral/' + id,
    method: 'get'
  })
}

// 新增用户积分
export function addIntegral(data) {
  return request({
    url: '/integral',
    method: 'post',
    data: data
  })
}

// 修改用户积分
export function updateIntegral(data) {
  return request({
    url: '/integral',
    method: 'put',
    data: data
  })
}

// 删除用户积分
export function delIntegral(id) {
  return request({
    url: '/integral/' + id,
    method: 'delete'
  })
}
