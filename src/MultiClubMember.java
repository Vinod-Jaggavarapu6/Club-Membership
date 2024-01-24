public class MultiClubMember extends Member{
    public int getMemberShipPoints() {
        return memberShipPoints;
    }

    public void setMemberShipPoints(int memberShipPoints) {
        this.memberShipPoints = memberShipPoints;
    }

    private int memberShipPoints;

    public MultiClubMember(char pMemberType,int pMemberID,String pName,double pFees,int pMembershipPoints){
        super(pMemberType,pMemberID,pName,pFees);
        memberShipPoints = pMembershipPoints;
    }

    @Override
    public String toString(){
        return super.toString()+", "+memberShipPoints;
    }

}
