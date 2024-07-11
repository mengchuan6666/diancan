import request from '@/utils/request'

// 查询排号记录列表
export function listNum(query) {
  return request({
    url: '/num/list',
    method: 'get',
    params: query
  })
}

// 查询排号记录详细
export function getNum(id) {
  return request({
    url: '/num/' + id,
    method: 'get'
  })
}

// 新增排号记录
export function addNum(data) {
  return request({
    url: '/num',
    method: 'post',
    data: data
  })
}

// 修改排号记录
export function updateNum(data) {
  return request({
    url: '/num',
    method: 'put',
    data: data
  })
}

// 删除排号记录
export function delNum(id) {
  return request({
    url: '/num/' + id,
    method: 'delete'
  })
}
