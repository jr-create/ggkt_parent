import request from '@/utils/request'

const api_name = '/admin/vod/teacher'

export default {
  // 讲师列表
  // page当前页 limit每页记录数 searchObj条件对象
  pageList(page, limit, searchObj) {
    return request({
      url: `${api_name}/findQueryPage/${page}/${limit}`,
      method: `post`,
      // 使用json格式传递，写法 data:searchObj
      // 使用普通格式，写法 params:searchObj
      data: searchObj
    })
  },
  // 讲师删除
  // page当前页 limit每页记录数 searchObj条件对象
  removeTeacherId(id) {
    return request({
      url: `${api_name}/remove/${id}`,
      method: `delete`
    })
  },
  //  讲师添加
  saveTeacher(teacher) {
    return request({
      url: `${api_name}/save`,
      method: `post`,
      data: teacher
    })
  },
  // 根据id查询
  getById(id) {
    return request({
      url: `${api_name}/get/${id}`,
      method: `get`
    })
  },
  //  讲师添加
  updataTeacher(teacher) {
    return request({
      url: `${api_name}/updateTeacher`,
      method: `put`,
      data: teacher
    })
  },
  batchRemove(idList) {
    return request({
      url: `${api_name}/batchRemove`,
      method: `delete`,
      data: idList
    })
  },
  //所有讲师
  list() {
    return request({
      url: `${api_name}/findAll`,
      method: `get`
    })
  }
}
