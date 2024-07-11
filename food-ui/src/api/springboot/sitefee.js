import request from '@/utils/request'

// 查询场地费用列表
export function listSitefee(query) {
  return request({
    url: '/springboot/sitefee/list',
    method: 'get',
    params: query
  })
}

// 查询场地费用详细
export function getSitefee(id) {
  return request({
    url: '/springboot/sitefee/' + id,
    method: 'get'
  })
}

// 新增场地费用
export function addSitefee(data) {
  return request({
    url: '/springboot/sitefee',
    method: 'post',
    data: data
  })
}

// 修改场地费用
export function updateSitefee(data) {
  return request({
    url: '/springboot/sitefee',
    method: 'put',
    data: data
  })
}

// 删除场地费用
export function delSitefee(id) {
  return request({
    url: '/springboot/sitefee/' + id,
    method: 'delete'
  })
}
