import request from '@/utils/request'
const api_name = '/admin/vod'

export default {
  //删除视频
  removeByVodId(id) {
    return request({
      url: `${api_name}/file/remove/${id}`,
      method: 'delete'
    })
  }
}
