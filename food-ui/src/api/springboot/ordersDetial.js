import request from '@/utils/request'

// 查询订单列表
export function listOrdersDetail(query) {
  return request({
    url: '/detail/list',
    method: 'get',
    params: query
  })
}

// 查询订单详细
export function getOrders(id) {
  return request({
    url: '/springboot/orders/' + id,
    method: 'get'
  })
}

// 新增订单
export function addOrders(data) {
  return request({
    url: '/springboot/orders',
    method: 'post',
    data: data
  })
}

// 修改订单
export function updateOrders(data) {
  return request({
    url: '/springboot/orders',
    method: 'put',
    data: data
  })
}


export function handleWriteOffUpdate(data) {
  return request({
    url: '/springboot/orders/writeOff',
    method: 'put',
    data: data
  })
}
// 删除订单
export function delOrders(id) {
  return request({
    url: '/springboot/orders/' + id,
    method: 'delete'
  })
}
