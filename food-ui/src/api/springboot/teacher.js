import request from '@/utils/request'

// 查询教工导入数据列表
export function listTeacher(query) {
  return request({
    url: '/teacher/list',
    method: 'get',
    params: query
  })
}

// 查询教工导入数据详细
export function getTeacher(id) {
  return request({
    url: '/teacher/' + id,
    method: 'get'
  })
}

// 新增教工导入数据
export function addTeacher(data) {
  return request({
    url: '/teacher',
    method: 'post',
    data: data
  })
}

// 修改教工导入数据
export function updateTeacher(data) {
  return request({
    url: '/teacher',
    method: 'put',
    data: data
  })
}

// 删除教工导入数据
export function delTeacher(id) {
  return request({
    url: '/teacher/' + id,
    method: 'delete'
  })
}
