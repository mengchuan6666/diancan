import request from '@/utils/request'

// 查询活动报名用户列表
export function listActivityUser(query) {
  return request({
    url: '/ActivityUser/list',
    method: 'get',
    params: query
  })
}

// 查询活动报名用户详细
export function getActivityUser(id) {
  return request({
    url: '/ActivityUser/' + id,
    method: 'get'
  })
}

// 新增活动报名用户
export function addActivityUser(data) {
  return request({
    url: '/ActivityUser',
    method: 'post',
    data: data
  })
}

// 修改活动报名用户
export function updateActivityUser(data) {
  return request({
    url: '/ActivityUser',
    method: 'put',
    data: data
  })
}

// 删除活动报名用户
export function delActivityUser(id) {
  return request({
    url: '/ActivityUser/' + id,
    method: 'delete'
  })
}
