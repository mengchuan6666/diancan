import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listCart(query) {
  return request({
    url: '/cart/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getCart(id) {
  return request({
    url: '/cart/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addCart(data) {
  return request({
    url: '/cart',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateCart(data) {
  return request({
    url: '/cart',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delCart(id) {
  return request({
    url: '/cart/' + id,
    method: 'delete'
  })
}
