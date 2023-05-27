function logoutApi(){
  return $axios({
    'url': '/loginController/logout',
    'method': 'post',
  })
}
