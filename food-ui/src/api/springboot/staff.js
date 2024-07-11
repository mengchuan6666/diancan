import request from '@/utils/request'

// 查询教职员工列表
export function listStaff(query) {
  return request({
    url: '/springboot/staff/list',
    method: 'get',
    params: query
  })
}

// 查询教职员工详细
export function getStaff(id) {
  return request({
    url: '/springboot/staff/' + id,
    method: 'get'
  })
}

// 新增教职员工
export function addStaff(data) {
  return request({
    url: '/springboot/staff',
    method: 'post',
    data: data
  })
}

// 修改教职员工
export function updateStaff(data) {
  return request({
    url: '/springboot/staff',
    method: 'put',
    data: data
  })
}

// 删除教职员工
export function delStaff(id) {
  return request({
    url: '/springboot/staff/' + id,
    method: 'delete'
  })
}
