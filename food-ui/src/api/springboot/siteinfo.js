import request from '@/utils/request'

// 查询场地管理列表
export function listSiteinfo(query) {
  return request({
    url: '/springboot/siteinfo/list',
    method: 'get',
    params: query
  })
}

// 查询场地管理详细
export function getSiteinfo(id) {
  return request({
    url: '/springboot/siteinfo/' + id,
    method: 'get'
  })
}

// 新增场地管理
export function addSiteinfo(data) {
  return request({
    url: '/springboot/siteinfo',
    method: 'post',
    data: data
  })
}

// 修改场地管理
export function updateSiteinfo(data) {
  return request({
    url: '/springboot/siteinfo',
    method: 'put',
    data: data
  })
}

// 删除场地管理
export function delSiteinfo(id) {
  return request({
    url: '/springboot/siteinfo/' + id,
    method: 'delete'
  })
}
