package management;

import datastructures.maps.CustomHashMap;
import library.Member;
import library.Transaction;

public class MemberManager {
    private CustomHashMap<String, Member> members;

    public MemberManager() {
        this.members = new CustomHashMap<>();
    }

    public void addMember(Member member) {
        if (member == null) {
            throw new NullPointerException("Cannot add null member");
        }
        members.put(member.getMemberId(), member);
    }

    public Member getMember(String memberId) {
        if (memberId == null) {
            throw new NullPointerException("Member ID cannot be null");
        }
        return members.get(memberId);
    }

    public void recordTransaction(String memberId, Transaction transaction) {
        Member member = getMember(memberId);
        if (member != null) {
            member.addTransaction(transaction);
        }
    }

    public Transaction getLastTransaction(String memberId) {
        Member member = getMember(memberId);
        if (member != null) {
            return member.getLastTransaction();
        }
        return null;
    }
}
