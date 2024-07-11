import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listSmalltype(query) {
  return request({
    url: '/smalltype/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getSmalltype(id) {
  return request({
    url: '/smalltype/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addSmalltype(data) {
  return request({
    url: '/smalltype',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateSmalltype(data) {
  return request({
    url: '/smalltype',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delSmalltype(id) {
  return request({
    url: '/smalltype/' + id,
    method: 'delete'
  })
}
