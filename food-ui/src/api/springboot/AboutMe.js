import request from '@/utils/request'

// 查询关于我们列表
export function listAboutMe(query) {
  return request({
    url: 'AboutMe/list',
    method: 'get',
    params: query
  })
}

// 查询关于我们详细
export function getAboutMe(id) {
  return request({
    url: 'AboutMe/' + id,
    method: 'get'
  })
}

// 新增关于我们
export function addAboutMe(data) {
  return request({
    url: 'AboutMe',
    method: 'post',
    data: data
  })
}

// 修改关于我们
export function updateAboutMe(data) {
  return request({
    url: 'AboutMe',
    method: 'put',
    data: data
  })
}

// 删除关于我们
export function delAboutMe(id) {
  return request({
    url: 'AboutMe/' + id,
    method: 'delete'
  })
}
