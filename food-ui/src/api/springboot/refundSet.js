import request from '@/utils/request'

// 查询退款申请列表
export function listSet(query) {
  return request({
    url: '/venueReservation/setRefund/list',
    method: 'get',
    params: query
  })
}

// 查询退款申请详细
export function getSet(id) {
  return request({
    url: '/venueReservation/setRefund/' + id,
    method: 'get'
  })
}

// 新增退款申请
export function addSet(data) {
  return request({
    url: '/venueReservation/setRefund',
    method: 'post',
    data: data
  })
}

// 修改退款申请
export function updateSet(data) {
  return request({
    url: '/venueReservation/setRefund',
    method: 'put',
    data: data
  })
}

// 删除退款申请
export function delSet(id) {
  return request({
    url: '/venueReservation/setRefund/' + id,
    method: 'delete'
  })
}
