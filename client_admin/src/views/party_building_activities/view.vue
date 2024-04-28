<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','activity_name') || $check_field('add','activity_name') || $check_field('set','activity_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="活动名称" prop="activity_name">
												<el-input id="activity_name" v-model="form['activity_name']" placeholder="请输入活动名称"
							  v-if="user_group === '管理员' || (form['party_building_activities_id'] && $check_field('set','activity_name')) || (!form['party_building_activities_id'] && $check_field('add','activity_name'))" :disabled="disabledObj['activity_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','activity_name')">{{form['activity_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','activity_type') || $check_field('add','activity_type') || $check_field('set','activity_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="活动类型" prop="activity_type">
												<el-input id="activity_type" v-model="form['activity_type']" placeholder="请输入活动类型"
							  v-if="user_group === '管理员' || (form['party_building_activities_id'] && $check_field('set','activity_type')) || (!form['party_building_activities_id'] && $check_field('add','activity_type'))" :disabled="disabledObj['activity_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','activity_type')">{{form['activity_type']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','manager_name') || $check_field('add','manager_name') || $check_field('set','manager_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="管理者姓名" prop="manager_name">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_manager_name(form['manager_name']) }}
							<!--<el-input id="business_name" v-model="form['manager_name']" placeholder="请输入管理者姓名"-->
							<!--v-if="user_group === '管理员' || (form['party_building_activities_id'] && $check_field('set','manager_name')) || (!form['party_building_activities_id'] && $check_field('add','manager_name'))" :disabled="disabledObj['manager_name_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','manager_name')">{{form['manager_name']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['party_building_activities_id'] && $check_field('set','manager_name')) || (!form['party_building_activities_id'] && $check_field('add','manager_name'))" id="manager_name" v-model="form['manager_name']" :disabled="disabledObj['manager_name_isDisabled']">
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
								<el-col v-if="user_group === '管理员' || $check_field('get','participants') || $check_field('add','participants') || $check_field('set','participants')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="参加人员" prop="participants">
												<el-input id="participants" v-model="form['participants']" placeholder="请输入参加人员"
							  v-if="user_group === '管理员' || (form['party_building_activities_id'] && $check_field('set','participants')) || (!form['party_building_activities_id'] && $check_field('add','participants'))" :disabled="disabledObj['participants_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','participants')">{{form['participants']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','activity_date') || $check_field('add','activity_date') || $check_field('set','activity_date')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="活动日期" prop="activity_date">
								<el-date-picker :disabled="disabledObj['activity_date_isDisabled']" v-if="user_group === '管理员' || (form['party_building_activities_id'] && $check_field('set','activity_date')) || (!form['party_building_activities_id'] && $check_field('add','activity_date'))" id="activity_date"
						v-model="form['activity_date']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','activity_date')">{{form['activity_date']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','event_details') || $check_field('add','event_details') || $check_field('set','event_details')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="活动详情" prop="event_details">
								<el-input type="textarea" id="event_details" v-model="form['event_details']" placeholder="请输入活动详情"
						v-if="user_group === '管理员' || (form['party_building_activities_id'] && $check_field('set','event_details')) || (!form['party_building_activities_id'] && $check_field('add','event_details'))" :disabled="disabledObj['event_details_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','event_details')">{{form['event_details']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','activity_cover') || $check_field('add','activity_cover') || $check_field('set','activity_cover')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="活动封面" prop="activity_cover">
								<el-upload :disabled="disabledObj['activity_cover_isDisabled']" id="activity_cover" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_activity_cover"
						:show-file-list="false" v-if="user_group === '管理员' || (form['party_building_activities_id'] && $check_field('set','activity_cover')) || (!form['party_building_activities_id'] && $check_field('add','activity_cover'))">
						<img v-if="form['activity_cover']" :src="$fullUrl(form['activity_cover'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','activity_cover')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['activity_cover'])" :preview-src-list="[$fullUrl(form['activity_cover'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','activity_attachment') || $check_field('add','activity_attachment') || $check_field('set','activity_attachment')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="活动附件" prop="activity_attachment">
												<div v-if="disabledObj['activity_attachment_isDisabled']">
						<div v-if="$check_field('get','activity_attachment')">
							<el-button type="primary" @click="$download($fullUrl(form['activity_attachment']),form['activity_attachment'])">下载<i
									class="el-icon-download el-icon--right"></i></el-button>
						</div>
					</div>
					<div v-else>
						<el-upload v-if="user_group === '管理员' || (form['party_building_activities_id'] && $check_field('set','activity_attachment')) || (!form['party_building_activities_id'] && $check_field('add','activity_attachment'))" class="upload-demo" drag
								   action="" style="max-width: 300px;width: 100%;" :http-request="upload_activity_attachment" :limit="1" accept="">
							<i class="el-icon-upload"></i>
							<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
						</el-upload>
						<div v-else-if="$check_field('get','activity_attachment')">
							<el-button type="primary" @click="$download($fullUrl(form['activity_attachment']),form['activity_attachment'])">下载<i
									class="el-icon-download el-icon--right"></i></el-button>
						</div>
					</div>
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
				field: "party_building_activities_id",
				url_add: "~/api/party_building_activities/add?",
				url_set: "~/api/party_building_activities/set?",
				url_get_obj: "~/api/party_building_activities/get_obj?",
				url_upload: "~/api/party_building_activities/upload?",

				query: {
					"party_building_activities_id": 0,
				},

				form: {
								"activity_name":  '', // 活动名称
										"activity_type":  '', // 活动类型
										"manager_name": 0, // 管理者姓名
										"participants":  '', // 参加人员
										"activity_date":  '', // 活动日期
										"event_details":  '', // 活动详情
										"activity_cover":  '', // 活动封面
										"activity_attachment":  '', // 活动附件
											"party_building_activities_id": 0, // ID
						
				},
				disabledObj:{
								"activity_name_isDisabled": false,
										"activity_type_isDisabled": false,
										"manager_name_isDisabled": false,
										"participants_isDisabled": false,
										"activity_date_isDisabled": false,
										"event_details_isDisabled": false,
										"activity_cover_isDisabled": false,
										"activity_attachment_isDisabled": false,
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
			 * 上传活动封面
			 * @param {Object} param 图片参数
			 */
			upload_activity_cover(param){
						this.uploadFile(param.file, "activity_cover");
					},
	
	
						/**
			 * 上传活动附件
			 * @param {Object} param 文件参数
			 */
			upload_activity_attachment(param){
						this.uploadFile(param.file, "activity_attachment");
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
										        if (this.form["activity_date"].indexOf("-")===-1){
          this.form["activity_date"] = this.$toTime(parseInt(this.form["activity_date"]),"yyyy-MM-dd")
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


														        if(this.form["activity_date"]=="0000-00-00"){
          this.form["activity_date"] = null;
        }
				if(parseInt(this.form["activity_date"]) > 9999){
					this.form["activity_date"] = this.$toTime(parseInt(this.form["activity_date"]),"yyyy-MM-dd")
				}
											

			},


			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/party_building_activities/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/party_building_activities/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/party_building_activities/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/party_building_activities/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/party_building_activities/view','get');
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
