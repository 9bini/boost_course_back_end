package org.edwith.webbe.securityexam.service;

import org.edwith.webbe.securityexam.dto.Member;

public interface MemberService extends UserDbService {

	void addMember(Member member, boolean b);

	Member getMemberByEmail(String loginId);

}