import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listImage(query) {
  return request({
    url: '/image/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getImage(id) {
  return request({
    url: '/image/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addImage(data) {
  return request({
    url: '/image',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateImage(data) {
  return request({
    url: '/image',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delImage(id) {
  return request({
    url: '/image/' + id,
    method: 'delete'
  })
}
