<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','student_id') || $check_field('add','student_id') || $check_field('set','student_id')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="学号" prop="student_id">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_student_id(form['student_id']) }}
							<!--<el-input id="business_name" v-model="form['student_id']" placeholder="请输入学号"-->
							<!--v-if="user_group === '管理员' || (form['leave_information_id'] && $check_field('set','student_id')) || (!form['leave_information_id'] && $check_field('add','student_id'))" :disabled="disabledObj['student_id_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','student_id')">{{form['student_id']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['leave_information_id'] && $check_field('set','student_id')) || (!form['leave_information_id'] && $check_field('add','student_id'))" id="student_id" v-model="form['student_id']" :disabled="disabledObj['student_id_isDisabled']">
								<el-option v-for="o in list_user_student_id" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','student_id')" id="student_id" v-model="form['student_id']" :disabled="true">
								<el-option v-for="o in list_user_student_id" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="student_id" v-model="form['student_id']" :disabled="disabledObj['student_id_isDisabled']">
							<el-option v-for="o in list_user_student_id" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','full_name') || $check_field('add','full_name') || $check_field('set','full_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="姓名" prop="full_name">
												<el-input id="full_name" v-model="form['full_name']" placeholder="请输入姓名"
							  v-if="user_group === '管理员' || (form['leave_information_id'] && $check_field('set','full_name')) || (!form['leave_information_id'] && $check_field('add','full_name'))" :disabled="disabledObj['full_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','full_name')">{{form['full_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','party_lesson_theme') || $check_field('add','party_lesson_theme') || $check_field('set','party_lesson_theme')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="党课主题" prop="party_lesson_theme">
												<el-input id="party_lesson_theme" v-model="form['party_lesson_theme']" placeholder="请输入党课主题"
							  v-if="user_group === '管理员' || (form['leave_information_id'] && $check_field('set','party_lesson_theme')) || (!form['leave_information_id'] && $check_field('add','party_lesson_theme'))" :disabled="disabledObj['party_lesson_theme_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','party_lesson_theme')">{{form['party_lesson_theme']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','party_class_date') || $check_field('add','party_class_date') || $check_field('set','party_class_date')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="党课日期" prop="party_class_date">
								<el-date-picker :disabled="disabledObj['party_class_date_isDisabled']" v-if="user_group === '管理员' || (form['leave_information_id'] && $check_field('set','party_class_date')) || (!form['leave_information_id'] && $check_field('add','party_class_date'))" id="party_class_date"
						v-model="form['party_class_date']" type="datetime" placeholder="选择日期时间">
					</el-date-picker>
					<div v-else-if="$check_field('get','party_class_date')">{{form['party_class_date']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','reason_for_leave') || $check_field('add','reason_for_leave') || $check_field('set','reason_for_leave')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="请假原因" prop="reason_for_leave">
								<el-input type="textarea" id="reason_for_leave" v-model="form['reason_for_leave']" placeholder="请输入请假原因"
						v-if="user_group === '管理员' || (form['leave_information_id'] && $check_field('set','reason_for_leave')) || (!form['leave_information_id'] && $check_field('add','reason_for_leave'))" :disabled="disabledObj['reason_for_leave_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','reason_for_leave')">{{form['reason_for_leave']}}</div>
							</el-form-item>
			</el-col>
					
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "leave_information_id",
				url_add: "~/api/leave_information/add?",
				url_set: "~/api/leave_information/set?",
				url_get_obj: "~/api/leave_information/get_obj?",
				url_upload: "~/api/leave_information/upload?",

				query: {
					"leave_information_id": 0,
				},

				form: {
								"student_id": 0, // 学号
										"full_name":  '', // 姓名
										"party_lesson_theme":  '', // 党课主题
										"party_class_date":  '', // 党课日期
										"reason_for_leave":  '', // 请假原因
											"leave_information_id": 0, // ID
						
				},
				disabledObj:{
								"student_id_isDisabled": false,
										"full_name_isDisabled": false,
										"party_lesson_theme_isDisabled": false,
										"party_class_date_isDisabled": false,
										"reason_for_leave_isDisabled": false,
										},

	
					// 用户列表
				list_user_student_id: [],
						// 用户组
				group_user_student_id: "",
				
		
		
		
	
			}
		},
		methods: {


	
	
				/**
			 * 获取普通用户用户列表
			 */
			async get_list_user_student() {
                // if(this.user_group !== "管理员" && this.form["student_id"] === 0) {
                //     this.form["student_id"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=普通用户");
                if(json.result && json.result.list){
                    this.list_user_student_id = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					/**
			 * 获取普通用户用户组
			 */
			async get_group_user_student_id() {
							this.form["student_id"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=普通用户");
				if(json.result && json.result.obj){
					this.group_user_student_id = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_student_id(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_student_id.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
									for (let key in _this.form) {
							arrForm.push(key)
						}
												_this.form["student_id"] = id
									_this.disabledObj['student_id' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "student_id") {
			                      _this.form[arrForm[j]] = res.result.obj[arr[i]]
			                      _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								  break;
								} else {
								  _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								}
							  }
							}
						  }
						}
					}
				});
			},
					get_user_student_id(id){
				var obj = this.list_user_student_id.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
																			// 获取缓存数据附加
				form = $.db.get("form");
							$.push(this.form ,form);
												
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
							        if (this.form["party_class_date"].indexOf("-")===-1){
            this.form["party_class_date"] = this.$toTime(parseInt(this.form["party_class_date"]),"yyyy-MM-dd hh:mm:ss")
        }
								$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


										        if(this.form["party_class_date"]=="0000-00-00 00:00:00"){
          this.form["party_class_date"] = null;
        }
				if(parseInt(this.form["party_class_date"]) > 9999){
					this.form["party_class_date"] = this.$toTime(parseInt(this.form["party_class_date"]),"yyyy-MM-dd hh:mm:ss")
				}
						

			},


			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/leave_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/leave_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/leave_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/leave_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/leave_information/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
					this.get_list_user_student();
					this.get_group_user_student_id();
													},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
