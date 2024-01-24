public class SingleClubMember extends Member{
    public int getClub() {
        return club;
    }

    public void setClub(int club) {
        this.club = club;
    }

    private int club;

    public SingleClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pClub){
        super(pMemberType,pMemberID,pName,pFees);
        club = pClub;
    }

    @Override
    public String toString(){
        return super.toString()+", "+club;
    }
}
