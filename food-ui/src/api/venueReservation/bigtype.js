import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listBigtype(query) {
  return request({
    url: '/bigtype/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getBigtype(id) {
  return request({
    url: '/bigtype/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addBigtype(data) {
  return request({
    url: '/bigtype',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateBigtype(data) {
  return request({
    url: '/bigtype',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delBigtype(id) {
  return request({
    url: '/bigtype/' + id,
    method: 'delete'
  })
}
