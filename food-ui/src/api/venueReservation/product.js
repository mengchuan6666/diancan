import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listProduct(query) {
  return request({
    url: '/product/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getProduct(id) {
  return request({
    url: '/product/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addProduct(data) {
  return request({
    url: '/product',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateProduct(data) {
  return request({
    url: '/product',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delProduct(id) {
  return request({
    url: '/product/' + id,
    method: 'delete'
  })
}
