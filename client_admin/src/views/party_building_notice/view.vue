<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','notification_title') || $check_field('add','notification_title') || $check_field('set','notification_title')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="通知标题" prop="notification_title">
												<el-input id="notification_title" v-model="form['notification_title']" placeholder="请输入通知标题"
							  v-if="user_group === '管理员' || (form['party_building_notice_id'] && $check_field('set','notification_title')) || (!form['party_building_notice_id'] && $check_field('add','notification_title'))" :disabled="disabledObj['notification_title_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','notification_title')">{{form['notification_title']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','notification_type') || $check_field('add','notification_type') || $check_field('set','notification_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="通知类型" prop="notification_type">
												<el-input id="notification_type" v-model="form['notification_type']" placeholder="请输入通知类型"
							  v-if="user_group === '管理员' || (form['party_building_notice_id'] && $check_field('set','notification_type')) || (!form['party_building_notice_id'] && $check_field('add','notification_type'))" :disabled="disabledObj['notification_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','notification_type')">{{form['notification_type']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','manager_name') || $check_field('add','manager_name') || $check_field('set','manager_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="管理者姓名" prop="manager_name">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_manager_name(form['manager_name']) }}
							<!--<el-input id="business_name" v-model="form['manager_name']" placeholder="请输入管理者姓名"-->
							<!--v-if="user_group === '管理员' || (form['party_building_notice_id'] && $check_field('set','manager_name')) || (!form['party_building_notice_id'] && $check_field('add','manager_name'))" :disabled="disabledObj['manager_name_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','manager_name')">{{form['manager_name']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['party_building_notice_id'] && $check_field('set','manager_name')) || (!form['party_building_notice_id'] && $check_field('add','manager_name'))" id="manager_name" v-model="form['manager_name']" :disabled="disabledObj['manager_name_isDisabled']">
								<el-option v-for="o in list_user_manager_name" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','manager_name')" id="manager_name" v-model="form['manager_name']" :disabled="true">
								<el-option v-for="o in list_user_manager_name" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="manager_name" v-model="form['manager_name']" :disabled="disabledObj['manager_name_isDisabled']">
							<el-option v-for="o in list_user_manager_name" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','notice_details') || $check_field('add','notice_details') || $check_field('set','notice_details')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="通知详情" prop="notice_details">
								<el-input type="textarea" id="notice_details" v-model="form['notice_details']" placeholder="请输入通知详情"
						v-if="user_group === '管理员' || (form['party_building_notice_id'] && $check_field('set','notice_details')) || (!form['party_building_notice_id'] && $check_field('add','notice_details'))" :disabled="disabledObj['notice_details_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','notice_details')">{{form['notice_details']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','remarks') || $check_field('add','remarks') || $check_field('set','remarks')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="备注" prop="remarks">
								<el-input type="textarea" id="remarks" v-model="form['remarks']" placeholder="请输入备注"
						v-if="user_group === '管理员' || (form['party_building_notice_id'] && $check_field('set','remarks')) || (!form['party_building_notice_id'] && $check_field('add','remarks'))" :disabled="disabledObj['remarks_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','remarks')">{{form['remarks']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','notice_attachment') || $check_field('add','notice_attachment') || $check_field('set','notice_attachment')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="通知附件" prop="notice_attachment">
												<div v-if="disabledObj['notice_attachment_isDisabled']">
						<div v-if="$check_field('get','notice_attachment')">
							<el-button type="primary" @click="$download($fullUrl(form['notice_attachment']),form['notice_attachment'])">下载<i
									class="el-icon-download el-icon--right"></i></el-button>
						</div>
					</div>
					<div v-else>
						<el-upload v-if="user_group === '管理员' || (form['party_building_notice_id'] && $check_field('set','notice_attachment')) || (!form['party_building_notice_id'] && $check_field('add','notice_attachment'))" class="upload-demo" drag
								   action="" style="max-width: 300px;width: 100%;" :http-request="upload_notice_attachment" :limit="1" accept="">
							<i class="el-icon-upload"></i>
							<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
						</el-upload>
						<div v-else-if="$check_field('get','notice_attachment')">
							<el-button type="primary" @click="$download($fullUrl(form['notice_attachment']),form['notice_attachment'])">下载<i
									class="el-icon-download el-icon--right"></i></el-button>
						</div>
					</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','notice_cover') || $check_field('add','notice_cover') || $check_field('set','notice_cover')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="通知封面" prop="notice_cover">
								<el-upload :disabled="disabledObj['notice_cover_isDisabled']" id="notice_cover" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_notice_cover"
						:show-file-list="false" v-if="user_group === '管理员' || (form['party_building_notice_id'] && $check_field('set','notice_cover')) || (!form['party_building_notice_id'] && $check_field('add','notice_cover'))">
						<img v-if="form['notice_cover']" :src="$fullUrl(form['notice_cover'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','notice_cover')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['notice_cover'])" :preview-src-list="[$fullUrl(form['notice_cover'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
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
				field: "party_building_notice_id",
				url_add: "~/api/party_building_notice/add?",
				url_set: "~/api/party_building_notice/set?",
				url_get_obj: "~/api/party_building_notice/get_obj?",
				url_upload: "~/api/party_building_notice/upload?",

				query: {
					"party_building_notice_id": 0,
				},

				form: {
								"notification_title":  '', // 通知标题
										"notification_type":  '', // 通知类型
										"manager_name": 0, // 管理者姓名
										"notice_details":  '', // 通知详情
										"remarks":  '', // 备注
										"notice_attachment":  '', // 通知附件
										"notice_cover":  '', // 通知封面
											"party_building_notice_id": 0, // ID
						
				},
				disabledObj:{
								"notification_title_isDisabled": false,
										"notification_type_isDisabled": false,
										"manager_name_isDisabled": false,
										"notice_details_isDisabled": false,
										"remarks_isDisabled": false,
										"notice_attachment_isDisabled": false,
										"notice_cover_isDisabled": false,
										},

	
		
		
					// 用户列表
				list_user_manager_name: [],
						// 用户组
				group_user_manager_name: "",
				
		
		
		
	
			}
		},
		methods: {


	
	
			
	
			
	
				/**
			 * 获取普通管理者用户列表
			 */
			async get_list_user_manager_name() {
                // if(this.user_group !== "管理员" && this.form["manager_name"] === 0) {
                //     this.form["manager_name"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=普通管理者");
                if(json.result && json.result.list){
                    this.list_user_manager_name = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					/**
			 * 获取普通管理者用户组
			 */
			async get_group_user_manager_name() {
							this.form["manager_name"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=普通管理者");
				if(json.result && json.result.obj){
					this.group_user_manager_name = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_manager_name(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_manager_name.source_table+"/get_obj?"
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
												_this.form["manager_name"] = id
									_this.disabledObj['manager_name' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "manager_name") {
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
					get_user_manager_name(id){
				var obj = this.list_user_manager_name.getObj({"user_id":id});
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
			 * 上传通知附件
			 * @param {Object} param 文件参数
			 */
			upload_notice_attachment(param){
						this.uploadFile(param.file, "notice_attachment");
					},
	
	
						/**
			 * 上传通知封面
			 * @param {Object} param 图片参数
			 */
			upload_notice_cover(param){
						this.uploadFile(param.file, "notice_cover");
					},
	
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
																						
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
																		$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


																					

			},


			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/party_building_notice/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/party_building_notice/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/party_building_notice/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/party_building_notice/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/party_building_notice/view','get');
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
									this.get_list_user_manager_name();
					this.get_group_user_manager_name();
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
