import request from '@/utils/request'

// 查询商品评论列表
export function listComment(query) {
  return request({
    url: '/comment/list',
    method: 'get',
    params: query
  })
}

// 查询商品评论详细
export function getComment(id) {
  return request({
    url: '/comment/' + id,
    method: 'get'
  })
}

// 新增商品评论
export function addComment(data) {
  return request({
    url: '/comment',
    method: 'post',
    data: data
  })
}

// 修改商品评论
export function updateComment(data) {
  return request({
    url: '/comment',
    method: 'put',
    data: data
  })
}

// 删除商品评论
export function delComment(id) {
  return request({
    url: '/comment/' + id,
    method: 'delete'
  })
}
