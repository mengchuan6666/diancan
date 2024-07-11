import request from '@/utils/request'

// 查询运动分类管理列表
export function listType(query) {
  return request({
    url: '/springboot/type/list',
    method: 'get',
    params: query
  })
}

// 查询运动分类管理详细
export function getType(id) {
  return request({
    url: '/springboot/type/' + id,
    method: 'get'
  })
}

// 新增运动分类管理
export function addType(data) {
  return request({
    url: '/springboot/type',
    method: 'post',
    data: data
  })
}

// 修改运动分类管理
export function updateType(data) {
  return request({
    url: '/springboot/type',
    method: 'put',
    data: data
  })
}

// 删除运动分类管理
export function delType(id) {
  return request({
    url: '/springboot/type/' + id,
    method: 'delete'
  })
}
