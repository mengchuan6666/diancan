import request from '@/utils/request'

// 查询关于我们列表
export function listBigType(query) {
    return request({
        url: '/admin/bigType/list',
        method: 'POST',
        params: query
    })
}

// 查询关于我们详细
export function getBigType(id) {
    return request({
        url: 'BigType/' + id,
        method: 'get'
    })
}

// 新增关于我们
export function addBigType(data) {
    return request({
        url: 'BigType',
        method: 'post',
        data: data
    })
}

// 修改关于我们
export function updateBigType(data) {
    return request({
        url: 'BigType',
        method: 'put',
        data: data
    })
}

// 删除关于我们
export function delBigType(id) {
    return request({
        url: 'BigType/' + id,
        method: 'delete'
    })
}
