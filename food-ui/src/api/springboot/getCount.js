import request from '@/utils/request'

// 查询关于我们列表
export function getCount() {
  return request({
    url: '/order/getCount',
    method: 'get',
    params: {}
  })
}

export function getProductCount() {
  return request({
    url: 'product/getProductCount',
    method: 'get'
  })
}

// 新增关于我们
export function getuserCount() {
  return request({
    url: '/user/count',
    method: 'get'
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
