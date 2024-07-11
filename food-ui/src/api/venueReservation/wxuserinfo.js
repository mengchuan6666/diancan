import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listWxuserinfo(query) {
  return request({
    url: '/wxuserinfo/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getWxuserinfo(id) {
  return request({
    url: '/wxuserinfo/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addWxuserinfo(data) {
  return request({
    url: '/wxuserinfo',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateWxuserinfo(data) {
  return request({
    url: '/wxuserinfo',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delWxuserinfo(id) {
  return request({
    url: '/wxuserinfo/' + id,
    method: 'delete'
  })
}
