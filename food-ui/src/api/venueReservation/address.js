import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listAddress(query) {
  return request({
    url: '/address/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getAddress(id) {
  return request({
    url: '/address/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addAddress(data) {
  return request({
    url: '/address',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateAddress(data) {
  return request({
    url: '/address',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delAddress(id) {
  return request({
    url: '/address/' + id,
    method: 'delete'
  })
}
