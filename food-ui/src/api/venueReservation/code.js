import request from '@/utils/request'

// 查询二维码管理列表
export function listCode(query) {
  return request({
    url: '/code/list',
    method: 'get',
    params: query
  })
}

// 查询二维码管理详细
export function getCode(id) {
  return request({
    url: '/code/' + id,
    method: 'get'
  })
}

// 新增二维码管理
export function addCode(data) {
  return request({
    url: '/code',
    method: 'post',
    data: data
  })
}

// 修改二维码管理
export function updateCode(data) {
  return request({
    url: '/code',
    method: 'put',
    data: data
  })
}

// 删除二维码管理
export function delCode(id) {
  return request({
    url: '/code/' + id,
    method: 'delete'
  })
}
