import request from '@/utils/request'

// 查询场馆管理列表
export function listVenueInfo(query) {
  return request({
    url: '/venueInfo/venueInfo/list',
    method: 'get',
    params: query
  })
}
// 查询运动类别列表
export function listSport(query) {
  return request({
    url: '/springboot/type/list',
    method: 'get',
    params: query
  })
}

// 查询场馆管理详细
export function getVenueInfo(id) {
  return request({
    url: '/venueInfo/venueInfo/' + id,
    method: 'get'
  })
}

// 新增场馆管理
export function addVenueInfo(data) {
  return request({
    url: '/venueInfo/venueInfo',
    method: 'post',
    data: data
  })
}

// 修改场馆管理
export function updateVenueInfo(data) {
  return request({
    url: '/venueInfo/venueInfo',
    method: 'put',
    data: data
  })
}

// 删除场馆管理
export function delVenueInfo(id) {
  return request({
    url: '/venueInfo/venueInfo/' + id,
    method: 'delete'
  })
}
