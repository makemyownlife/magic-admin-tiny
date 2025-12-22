import { service } from './service'

import { config } from './config'

const { default_headers } = config

const request = (option: any) => {
  const { headersType, headers, ...otherOption } = option;

  return service({
    ...otherOption,
    headers: {
      'Content-Type': headersType || default_headers,
      ...headers
    }
  }).catch((error) => {
    // 捕获请求的错误并抛出 Error 对象
    throw new Error(error.message || 'Request failed');
  });
}

export default {
  get: async <T = any>(option: any) => {
    const res = await request({ method: 'GET', ...option })
    return res.data as unknown as T
  },
  post: async <T = any>(option: any) => {
    try {
      const res = await request({ method: 'POST', ...option });
      // 检查响应数据是否有效
      if (res && res.data) {
        return res.data as unknown as T;
      } else {
        throw new Error('Response data is invalid');
      }
    } catch (error: any) {
      // 判断错误类型
      if (typeof error === 'string') {
        // 如果是字符串错误，转换为 Error 对象
        error = new Error(error);
      }

      console.error('POST request failed:', error);

      // 可以根据需要返回一个自定义错误，或者抛出异常
      throw error; // 重新抛出错误，或者你可以返回自定义的错误对象
    }
  },
  postOriginal: async (option: any) => {
    const res = await request({ method: 'POST', ...option })
    return res
  },
  delete: async <T = any>(option: any) => {
    const res = await request({ method: 'DELETE', ...option })
    return res.data as unknown as T
  },
  put: async <T = any>(option: any) => {
    const res = await request({ method: 'PUT', ...option })
    return res.data as unknown as T
  },
  download: async <T = any>(option: any) => {
    const res = await request({ method: 'GET', responseType: 'blob', ...option })
    return res as unknown as Promise<T>
  },
  upload: async <T = any>(option: any) => {
    option.headersType = 'multipart/form-data'
    const res = await request({ method: 'POST', ...option })
    return res as unknown as Promise<T>
  }
}
