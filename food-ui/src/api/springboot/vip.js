import request from '@/utils/request'

// 查询vip会员列表
export function listVip(query) {
  return request({
    url: '/springboot/vip/list',
    method: 'get',
    params: query
  })
}

// 查询vip会员详细
export function getVip(id) {
  return request({
    url: '/springboot/vip/' + id,
    method: 'get'
  })
}

// 新增vip会员

export function addVip(data) {
  return request({
    url: '/springboot/vip',
    method: 'post',
    data: data
  })
}

// 修改vip会员

export function updateVip(data) {
  return request({
    url: '/springboot/vip',
    method: 'put',
    data: data
  })
}

// 删除vip会员

export function delVip(id) {
  return request({
    url: '/springboot/vip/' + id,
    method: 'delete'
  })
}
