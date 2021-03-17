package CounterStriker.models.guns;

public class Rifle extends GunImpl {
    private static final int BULLETS_FIRED = 10;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        int bulletsLeft = super.getBulletsCount() - BULLETS_FIRED;
        if (bulletsLeft < 0) {
            return 0;
        }
        super.setBulletsCount(bulletsLeft);
        return BULLETS_FIRED;
    }
}
