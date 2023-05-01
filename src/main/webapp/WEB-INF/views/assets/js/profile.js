document.getElementById("btn-modify").addEventListener("click", function () {
  let name = document.getElementById("myName").value;
  let pwd = document.getElementById("myPwd").value;
  let checkPwd = document.getElementById("myCheckPwd").value;
  let loginMember = JSON.parse(localStorage.getItem("loginMember"))
  if (pwd == "") {
    alert("비밀번호를 입력해주세요")
    return;
  }
  if (pwd != checkPwd) {
    alert("비밀번호가 일치하지 않습니다")
    return;
  }
  if (pwd == loginMember['pwd']) {
    alert("비밀번호가 이전과 일치합니다")
    return;
  }
  loginMember['name'] = name;
  loginMember['pwd'] = pwd;
  localStorage.setItem("loginMember", JSON.stringify(loginMember));
  localStorage.setItem(loginMember['id'], JSON.stringify(loginMember));
  alert("비밀번호가 변경되었습니다")
  return;
})

document.getElementById("btn-remove").addEventListener("click", function () {
  let loginMember = JSON.parse(localStorage.getItem("loginMember"))
  if (confirm("탈퇴하시겠습니까?")) {
    localStorage.removeItem("loginMember")
    localStorage.removeItem(loginMember['id'])
    alert("탈퇴가 완료되었습니다")
    location.href = 'index.html';
    return;
  }
})