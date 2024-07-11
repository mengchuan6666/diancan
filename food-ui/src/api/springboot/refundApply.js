import request from '@/utils/request'

// 查询退款申请列表
export function listApply(query) {
  return request({
    url: '/venueReservation/refundApply/list',
    method: 'get',
    params: query
  })
}

// 查询退款申请详细
export function getApply(id) {
  return request({
    url: '/venueReservation/refundApply/' + id,
    method: 'get'
  })
}

// 新增退款申请
export function addApply(data) {
  return request({
    url: '/venueReservation/refundApply',
    method: 'post',
    data: data
  })
}

// 修改退款申请
export function updateApply(data) {
  return request({
    url: '/venueReservation/refundApply',
    method: 'put',
    data: data
  })
}

// 删除退款申请
export function delApply(id) {
  return request({
    url: '/venueReservation/refundApply/' + id,
    method: 'delete'
  })
}
