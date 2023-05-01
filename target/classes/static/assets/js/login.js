// 로그인 눌렀을 때
document.querySelector(".btn-login-open").addEventListener("click", function () {
  document.getElementById('login-page').className = "mt-5";
  document.getElementById('register-page').className = "modal fade";
  document.getElementById('profile-page').className = "modal fade";


});

// 로그인 창 닫았을 때
document.getElementById("btn-login-close").addEventListener("click", function () {
  document.getElementById('login-page').className = "modal fade";
});

// 로그인 할 때
document.getElementById("btn-login").addEventListener("click", function () {
  let id = document.getElementById("l-id").value;
  let pwd = document.getElementById("l-password").value;
  var member = JSON.parse(localStorage.getItem(id))
  if (member == null) {
    alert("잘못된 아이디 혹은 비밀번호입니다.")
    return;
  }
  if (pwd != member.pwd) {
    alert("잘못된 아이디 혹은 비밀번호입니다.")
    return;
  }
  alert("로그인이 완료되었습니다.")
  localStorage.setItem("loginMember", JSON.stringify(member));
  document.getElementById('login-page').className = "modal fade";
  window.location.reload()

})


// 회원가입 눌렀을 때
document.querySelector(".btn-register-open").addEventListener("click", function () {
  document.getElementById('register-page').className = "mt-5";
  document.getElementById('profile-page').className = "modal fade";
  document.getElementById('login-page').className = "modal fade";
});

// 회원가입 창 닫았을 때
document.getElementById("btn-register-close").addEventListener("click", function () {
  document.getElementById('register-page').className = "modal fade";
});

// 회원가입 할 때
// TODO email 합쳐야 함
document.getElementById("btn-register").addEventListener("click", function () {
  let member = new Member();
  for (let key in member) {
    if (member[key] == "") {
      alert("입력을 모두 완료해주세요")
      return;
    }
  }
  if (member['pwd'] != member['checkPwd']) {
    alert("비밀번호가 일치하지 않습니다")
    return;
  }
  if (localStorage.getItem(member['id']) != null) {
    alert("이미 가입된 아이디입니다")
    return;
  }
  alert("회원가입 완료")
  localStorage.setItem(member['id'], JSON.stringify(member));
  document.getElementById('register-page').className = "modal fade";
})

// 내정보 눌렀을 때
document.querySelector(".btn-profile").addEventListener("click", function () {
  document.getElementById('login-page').className = "modal fade";
  document.getElementById('register-page').className = "modal fade";
  var loginMember = JSON.parse(localStorage.getItem("loginMember"));
  document.getElementById("myName").value = loginMember["name"];
  document.getElementById('profile-page').className = "mt-5";

});

// 수정 눌렀을 때
document.getElementById("btn-profile-close").addEventListener("click", function () {
  document.getElementById('profile-page').className = "modal fade";
});

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

// 탈퇴 눌렀을 때
document.getElementById("btn-remove").addEventListener("click", function () {
  let loginMember = JSON.parse(localStorage.getItem("loginMember"))
  if (confirm("탈퇴하시겠습니까?")) {
    localStorage.removeItem("loginMember")
    localStorage.removeItem(loginMember['id'])
    alert("탈퇴가 완료되었습니다")
    // location.href = 'index.html';
    document.getElementById('profile-page').className = "modal fade";
    window.location.reload()
    return;
  }
})

// 로그아웃 눌렀을 때
document.getElementsByClassName("btn-logout")[0].addEventListener("click", function() {
  localStorage.removeItem("loginMember");
  document.getElementById('profile-page').className = "modal fade";
  window.location.reload()
  
})


class Member {
  constructor() {
    this.name = document.getElementById("r-name").value
    this.id = document.getElementById("r-id").value;
    this.pwd = document.getElementById("r-password").value;
    this.checkPwd = document.getElementById("r-password-check").value;
    this.email1 = document.getElementById("r-email1").value;
    this.email2 = document.getElementById("r-email2").value;
    this.sido = document.getElementById("r-sido").value;
    this.gugun = document.getElementById("r-gugun").value;
  }
}