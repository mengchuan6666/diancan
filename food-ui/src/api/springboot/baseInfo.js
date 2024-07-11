import request from '@/utils/request'

// 查询基本信息配置列表
export function listBaseInfo(query) {
  return request({
    url: '/baseInfo/baseInfo/list',
    method: 'get',
    params: query
  })
}

// 查询基本信息配置详细
export function getBaseInfo(id) {
  return request({
    url: '/baseInfo/baseInfo/' + id,
    method: 'get'
  })
}

// 新增基本信息配置
export function addBaseInfo(data) {
  return request({
    url: '/baseInfo/baseInfo',
    method: 'post',
    data: data
  })
}

// 修改基本信息配置
export function updateBaseInfo(data) {
  return request({
    url: '/baseInfo/baseInfo',
    method: 'put',
    data: data
  })
}

// 删除基本信息配置
export function delBaseInfo(id) {
  return request({
    url: '/baseInfo/baseInfo/' + id,
    method: 'delete'
  })
}
