import request from '@/utils/request'

// 查询通卡管理列表
export function listCard(query) {
  return request({
    url: '/springboot/card/list',
    method: 'get',
    params: query
  })
}

// 查询通卡管理详细
export function getCard(id) {
  return request({
    url: '/springboot/card/' + id,
    method: 'get'
  })
}

// 新增通卡管理
export function addCard(data) {
  return request({
    url: '/springboot/card',
    method: 'post',
    data: data
  })
}

// 修改通卡管理
export function updateCard(data) {
  return request({
    url: '/springboot/card',
    method: 'put',
    data: data
  })
}

// 删除通卡管理
export function delCard(id) {
  return request({
    url: '/springboot/card/' + id,
    method: 'delete'
  })
}
