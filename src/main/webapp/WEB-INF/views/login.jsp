<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>            
	<c:if test="${cookie.ssafy_id.value ne null}">
		<c:set var="idck" value=" checked"/>
		<c:set var="saveid" value="${cookie.ssafy_id.value}"/>
	</c:if>
            <!-- The Modal -->
            <div class="modal" id="login">
              <div class="modal-dialog">
                <div class="modal-content">
                  <!-- Modal Header -->
                  <div class="modal-header">
                    <h4>로그인</h4>
                  </div>

                  <!-- Modal body -->
                  <div class="modal-body">
                    <div class="col-lg-8 col-md-10 col-sm-12">
                      <form id="form-login" method="POST" action="">
                        <input type="hidden" name="action" value="login" />

                        <div class="mb-3">
                          <label for="userid" class="form-label">아이디 : </label>
                          <input
                            type="text"
                            class="form-control"
                            id="lid"
                            name="lid"
                            placeholder="아이디..."
                            value="${saveid}"
                          />
                        </div>
                        <div class="form-check mb-3 float-end">
                          <input
                            class="form-check-input"
                            type="checkbox"
                            value="ok"
                            id="lsaveid"
                            name="lsaveid"
                            ${idck}
                          />
                          <label class="form-check-label" for="saveid"> 아이디저장 </label>
                        </div>
                        <div class="mb-3">
                          <label for="userpwd" class="form-label">비밀번호 : </label>
                          <input
                            type="password"
                            class="form-control"
                            id="lpwd"
                            name="lpwd"
                            placeholder="비밀번호..."
                          />
                        </div>
                        <div class="text-danger mb-2">${msg}</div>
                      </form>
                    </div>
                  </div>

                  <!-- Modal footer -->
                  <div class="modal-footer">
                    <div class="col-auto text-center">
                      <button type="button" id="btn-login" class="btn btn-outline-primary mb-3">
                        로그인
                      </button>
                      <button
                        type="button"
                        class="btn btn-outline-primary mb-3"
                        data-dismiss="modal"
                      >
                        취소
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </li>
          <script>
            document.getElementById("btn-login").addEventListener("click", function () {
              let form = document.getElementById("form-login");
              form.setAttribute("action", "${root}/member");
              form.submit();
            })
          </script>